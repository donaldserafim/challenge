package com.texoit.challenge.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Winner {
    private String producer;
    private int interval;
    private int previousWin;
    private int followingWin;
}
