package com.coffeetime.ctmessage.app.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface IMessageController {
    @GetMapping
    ResponseEntity<Iterable<M>>
}
