package com.example.grpc_client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GrpcTestController {

  // GrpcClient를 구현한 service inject
  private final GrpcExampleService grpcExampleService;

  public GrpcTestController(GrpcExampleService grpcExampleService) {
    this.grpcExampleService = grpcExampleService;
  }

  @GetMapping("{name}")
  public String getMethodName(@PathVariable String name) {
    return grpcExampleService.runExample(name);
  }

}
