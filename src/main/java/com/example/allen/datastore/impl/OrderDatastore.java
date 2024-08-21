package com.example.allen.datastore.impl;

import com.example.allen.datastore.KeyValueDatastore;
import com.example.allen.models.data.Deal;
import com.example.allen.models.data.Order;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class OrderDatastore extends KeyValueDatastore<String, Order> {

}
