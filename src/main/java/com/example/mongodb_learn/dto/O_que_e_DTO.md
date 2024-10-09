## DTO
**Referências:** [Stack Overflow: O que é DTO?](https://pt.stackoverflow.com/questions/31362/o-que-%C3%A9-um-dto)

**DTO** (*Data Transfer Object*): É um objeto que tem o papel de carregar dados das entidades de forma simples, podendo inclusive "projetar" apenas alguns dados da entidade original. Vantagens:

- Otimizar o tráfego (trafegando menos dados)

- Evitar que dados de interesse exclusivo do sistema fiquem sendo expostos (por exemplo: senhas, dados de auditoria como data de criação e data de atualização do objeto, etc.)

- Customizar os objetos trafegados conforme a necessidade de cada requisição (por exemplo: para alterar

um produto, você precisa dos dados A, B e C; já para listar os produtos, eu preciso dos dados A, B e a categoria de cada produto, etc.).