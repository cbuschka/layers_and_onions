package retour.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import retour.application.ProcessRetourBusinessService;
import retour.application.ProcessRetoureRequest;
import retour.application.ProcessRetoureResponse;

@RestController
public class ProcessRetourController {

    @Autowired
    private ProcessRetourBusinessService processRetourBusinessService;

    @PostMapping(path = "/retours")
    public ResponseEntity<ProcessRetoureResponse> processRetoure(ProcessRetoureRequest request) {
        ProcessRetoureResponse response = processRetourBusinessService.process(request);

        return ResponseEntity.ok(response);
    }
}
