package com.HandlerException.ErrorsController.UsersController;

import com.HandlerException.ErrorsController.Exceptions.NotFoundException;
import com.HandlerException.ErrorsController.User.User;
import com.fasterxml.uuid.Generators;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

public class UsersController {

    @GetMapping("/users/{id}")
    public Object getUsers(@PathVariable("id") Long id) {

        if (id == 3) {
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("operacion exitosa", HttpStatus.OK.value());
            body.put("mensaje", "Mario tiene el id " + id);


            return body;
        } else {
            throw new NotFoundException("No se encontro ningun usuario con la id " + id);
        }


    };

    private List<User> users = new ArrayList<>();
    @PostMapping("/newUser/{id}")
    public User postUsers(@Valid @RequestBody User user, @PathVariable Long id ) {

        UUID uuidV7 = Generators.timeBasedEpochGenerator().generate();
        user.setUuid(uuidV7);

        if (!Objects.equals(user.nombre, "mario")) {
            users.add(user);
            return user;
        } else {
            throw new NotFoundException("No se encontro el nombre en la base de datos ");
        }

    }
}
