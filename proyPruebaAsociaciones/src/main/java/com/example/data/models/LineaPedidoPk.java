package com.example.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaPedidoPk implements Serializable {

    private Pedido pedido;
    private Long id;
}
