package com.example.bluesyroom.dto.wish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WishResponseDto {

    private long userNo;

    private long productNo;

    private long status; // 0(찜 X) 1인지(찜 O)

    public WishResponseDto(long userNo, long productNo) {
        this.userNo = userNo;
        this.productNo = productNo;
    }
}
