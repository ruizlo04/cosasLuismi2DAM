package com.example.monumentos_CarlosRuiz.dto;

import com.example.monumentos_CarlosRuiz.models.Monument;

import java.util.List;

public record GetMonumentListDto(
        Long id,
        List<Monument> items
    ) {

    public static GetMonumentListDto of (List<Monument> items){
        return new GetMonumentListDto(
                (long) items.size(),
                items
        );
    }

    public List<Monument> to(){
        return items;
    }
}
