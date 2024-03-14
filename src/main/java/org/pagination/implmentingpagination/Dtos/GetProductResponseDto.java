package org.pagination.implmentingpagination.Dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductResponseDto {
    int numberOfProducts;
    int offset;
}
