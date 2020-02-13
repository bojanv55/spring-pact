# spring-pact

Project showing usage of spring cloud contract with pact broker (running using test-containers)

## producer

Has 1 pact test defined in .yml file in test/resources/contracts. Running `DemoTest` should just run pact-broker in docker (which will be accessible via some ip/port in browser `pact.getContainerIpAddress()`).

When we do maven clean, and then `mvn test`, it should generate pact test definitions in `target/pacts` folder. These pact definitions are then uploaded to pact-broker using `pact:publish` goal in maven. 

## consumer

Here we have `ConsoleRunnerTest` that connects to pact-broker server, downloads pact definition and runs it as a stub. Notice that `ids = "Some Consumer:Producer API"` is actually defined inside yml file as `name: "Some Consumer___Producer API___some test"` on the producer side. 
