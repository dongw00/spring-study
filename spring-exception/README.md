## Servlet 예외처리 

### 예외 발생 흐름 
```text
WAS(여기까지 전파) <- 필터 <- 서블릿 <- 인터셉터 <- 컨트롤러(예외발생)
(response.sendError())
```