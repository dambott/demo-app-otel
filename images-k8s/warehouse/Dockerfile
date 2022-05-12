FROM python:3.7

RUN apt update && apt install git python3-pip -y
 
# Install Wavefront Django Python SDK
RUN mkdir /wavefront 
WORKDIR /wavefront
# RUN git checkout hao/django-0.1.0
RUN pip3 install -e .
WORKDIR /

# Copy app and setup requirements
COPY warehouse /warehouse
WORKDIR /warehouse

# setup app requirements
RUN pip3 install -r requirements.txt

