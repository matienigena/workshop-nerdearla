# Workshop

`POST` /v1/payments
```json
{
  "qr_id": "1123",
  "buyer_id": 1,
  "seller_id": 2,
  "amount": 100.00,
  "installments": 1,
  "payment_method": {
    "token": "2342349085324239",
    "security_code": "103"
  },
  "terminal_data": {
    "establishment_id": "10",
    "terminal_number": "123",
    "trace_number": "123",
    "ticket_number": "1412",
    "transaction_datetime": "2019-01-02T17:00:00"
  }
}
```
