package com.example.grpc_client;

import org.springframework.stereotype.Service;

import example.proto.Example.HelloRequest;
import example.proto.ExampleProtoServiceGrpc.ExampleProtoServiceBlockingStub;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class GrpcExampleService {

  // @GrpcClient("{client 이름 - properties에서 설정할때 사용}")
  @GrpcClient("grpcExample")
  // {proto에 설정된 package}.{proto에 설정된 서비스}Grpc.{proto에 설정된 서비스}BlockingStub
  private ExampleProtoServiceBlockingStub exampleProtoServiceBlockingStub;

  public String runExample(String name) {
    HelloRequest request = HelloRequest.newBuilder().setName(name).build();
    return exampleProtoServiceBlockingStub.sayHello(request).getMessage();
  }
}
