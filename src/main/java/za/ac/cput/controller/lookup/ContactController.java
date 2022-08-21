package za.ac.cput.controller.lookup;
//        * aurthor : Mahad Hassan
//         *
//         * student number (219122822)
//         *
//         * Capstone Project
//         *
//         *
//         * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.Contact;
import za.ac.cput.service.lookup.Impl.ContactServiceImpl;

import javax.validation.Valid;
@RestController
@RequestMapping("contact")
public class ContactController {
    private final ContactServiceImpl service;

    @Autowired
    public ContactController(ContactServiceImpl service) {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<Contact> save(@Valid @RequestBody Contact contact){

        Contact saved = this.service.save(contact);
        return ResponseEntity.ok(saved);
    }


    @GetMapping("read")
    public ResponseEntity<Contact> read(String conId) {

        Contact read = service.read(conId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(read);

    }
    @DeleteMapping("delete")
    public  ResponseEntity<Void> delete(Contact contact) {
        this.service.delete(contact);
        return ResponseEntity.noContent().build();

    }
}
