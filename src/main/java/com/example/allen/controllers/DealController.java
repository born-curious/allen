package com.example.allen.controllers;

import com.example.allen.models.data.Deal;
import com.example.allen.models.requests.CreateDealRequest;
import com.example.allen.models.requests.EndDealRequest;
import com.example.allen.models.requests.UpdateDealRequest;
import com.example.allen.services.DealService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping(value = "/allen/deal")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DealController {

    private final DealService dealService;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody CreateDealRequest createDealRequest) {
        Deal deal = dealService.createDeal(createDealRequest);
        return new ResponseEntity<>(deal, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody UpdateDealRequest updateDealRequest) {
        Deal deal = dealService.updateDeal(updateDealRequest);
        return new ResponseEntity<>(deal, HttpStatus.OK);
    }

    @PutMapping("/endDeal")
    public ResponseEntity<?> end(@RequestBody EndDealRequest endDealRequest) {
        Deal deal = dealService.endDeal(endDealRequest);
        return new ResponseEntity<>(deal, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        Deal deal = dealService.getDeal(id);
        return new ResponseEntity<>(deal, HttpStatus.OK);
    }
}
