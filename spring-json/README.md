## @DateTimeFormat, @JsonFormat

### @DateTimeFormat

- Request 요청시 String -> LocalDateTime or LocalDate으로 변환
- 주로 GET

### @JsonFormat

- Response시 JSON으로 변환(Jackson 라이브러리 일부)
- JSON 직렬화
- @DateTImeFormat 사용시 JSON으로 변환 X(Jackson라이브러리를 사용하는 어노테이션이 아니라서)

## Reference

- https://jojoldu.tistory.com/361


