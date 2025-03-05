## Before Running Services
### Make sure there is a Kafka server running
```
cd infra
docker-compose up
```

## Run the backend micro-services
```
cd reservation
mvn clean spring-boot:run

cd notification
mvn clean spring-boot:run
```


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn clean spring-boot:run
```

## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to http://localhost:8088/#/

## 예약 알림 테스트

1. 예약 알림 테스트
```
curl -X POST http://localhost:8088/reservations \
-H "Content-Type: application/json" \
-d '{
    "targetUserIds": ["target_all_users"],
    "title": "예약 알림",
    "description": "예약 알림 설명 테스트 2",
    "isNow": false,
    "dueDate": "2025-02-25T17:53:00+09:00"
}'
```

2. 실시간 알림 테스트
```
curl -X POST http://localhost:8088/reservations \
-H "Content-Type: application/json" \
-d '{
    "targetUserIds": ["target_all_users"],
    "title": "실시간 알림",
    "description": "실시간 알림 설명 실시간 알림 설명실시간 알림 설명실시간 알림 설명실시간 알림 설명실시간 알림 설명실시간 알림 설명실시간 알림 설명실시간 알림 설명실시간 알림 설명실시간 알림 설명실시간 알림 설명실시간 알림 설명실시간 알림 설명",
    "isNow": true,
    "dueDate": null
}'
```
## PBC 적용 방법
https://github.com/kyusooK/Cluster-distribute-rule/blob/main/README.md
