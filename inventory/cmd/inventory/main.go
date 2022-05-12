package main

import (
	"encoding/json"
	"log"
	"os"
	"wavefront.com/polyglot/inventory/services/inventory"

	. "wavefront.com/polyglot/inventory/internal"
)

func main() {
	if len(os.Args) < 2 {
		log.Fatal("usage: inventory <config_file>")
	}

	log.Printf("Inventory main start")

	InitGlobalConfig()
	log.Printf("Inventory config")

	file, err := os.Open(os.Args[1])
	if err != nil {
		log.Fatalf("error reading config: %q", err)
	}
	if derr := json.NewDecoder(file).Decode(&GlobalConfig); derr != nil {
		log.Fatalf("error decoding config: %q", derr)
	}
	log.Printf("Inventory config2")

	//closer := NewStdoutTracer()

	closer := NewGlobalTracer(GlobalConfig.Service)
	defer closer.Close()
	log.Printf("Inventory config3")

	server := inventory.NewServer()
	if serr := server.Start(); serr != nil {
		log.Fatalf("error starting inventory service: %q", serr)
	}
	log.Printf("Inventory config4")
}
