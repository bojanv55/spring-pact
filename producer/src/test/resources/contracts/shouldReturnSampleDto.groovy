import org.springframework.cloud.contract.spec.Contract

Contract.make{
    name "Some Consumer___Producer API___some test"
    description "should return SampleDto"
    request{
        url "/list/bojan"
        method GET()
    }
    response{
        status 200
        body([id:1, name:"bojan"])
    }
}
