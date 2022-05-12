package inventory

import (
	"fmt"
	"github.com/go-chi/chi"
	"io"
	"log"
	"net/http"
	. "wavefront.com/polyglot/inventory/internal"
)

type InventoryService struct {
	HostURL string
	Router  *chi.Mux
}

func NewServer() *InventoryService {
	r := chi.NewRouter()
	server := &InventoryService{GlobalConfig.InventoryHost, r}
	r.Route("/inventory", func(r chi.Router) {
		r.Get("/available/{itemId}", server.available)
		r.Post("/checkout/{orderId}", server.checkout)
	})
	return server
}

func (s *InventoryService) Start() error {
	log.Printf("Inventory service listening on: %s", s.HostURL)
	return http.ListenAndServe(s.HostURL, s.Router)
}

func (s *InventoryService) available(w http.ResponseWriter, r *http.Request) {
	log.Printf("Inventory service available")
	span := NewServerSpan(r, "available")

	defer span.End()

	go async(r)
	// span.LogFields(otrlog.String("event", "created async"))

	RandSimDelay()

	exists := true
	if RAND.Float32() < GlobalConfig.SimFailAvailable {
		exists = false
	}

	if !exists {
		//otrext.Error.Set(span, true)
		//span.LogFields(otrlog.String("error.kind", "item does not exist"))
		WriteError(w, "Item does not exist", http.StatusNotFound)
		return
	}
	w.Write([]byte{byte(http.StatusOK)})
}

func (s *InventoryService) checkout(w http.ResponseWriter, r *http.Request) {
	log.Printf("Inventory service checkout")
	span := NewServerSpan(r, "checkout")
	defer span.End()

	go async(r)

	RandSimDelay()

	if RAND.Float32() < GlobalConfig.SimFailCheckout {
		//otrext.Error.Set(span, true)
		//span.LogFields(
		//	otrlog.String("error.kind", "gen-failure"),
		//	otrlog.String("message", "service unavailable"),
		//)
		WriteError(w, "checkout failure", http.StatusServiceUnavailable)
		return
	}

	resp, err := callWarehouse(r)
	if err != nil {
		//otrext.Error.Set(span, true)
		//span.LogFields(otrlog.String("message", err.Error()))
		WriteError(w, err.Error(), http.StatusPreconditionFailed)
		return
	}
	defer resp.Body.Close()

	RandSimDelay()

	if resp.StatusCode == http.StatusOK || resp.StatusCode == http.StatusAccepted {
		io.Copy(w, resp.Body)
	} else {
		//otrext.Error.Set(span, true)
		WriteError(w, fmt.Sprintf("failed to checkout: %s", resp.Status), resp.StatusCode)
	}
}

func callWarehouse(r *http.Request) (*http.Response, error) {
	span := NewServerSpan(r, "callWarehouse")
	defer span.End()
	getURL := fmt.Sprintf("http://%s/warehouse/%s", GlobalConfig.WarehouseHost, "32jf")
	//return GETCall(getURL, nil, spanCtx)
	return GETCall(getURL, nil)
}

func async(r *http.Request) {
	span := NewServerSpan(r, "inventoryAsync")
	defer span.End()
	RandSimDelay()
	RandSimDelay()
}
