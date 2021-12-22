package com.example.myrabbit.rabbit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Notification implements Serializable {
    private String id;
    private String text;
    private LocalDate createdDate;
    private Boolean seen;

}
