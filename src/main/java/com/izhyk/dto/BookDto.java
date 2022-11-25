package com.izhyk.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "book", collectionRelation = "books")
public class BookDto extends RepresentationModel<BookDto> {
    private final Integer id;
    private final String bookName;
    private final String author;
    private final String publisher;
    private final int imprintYear;
    private final int amount;
}
