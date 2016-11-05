# Backend APIs

## URL Base
```
https://apiondetemjogo.herokuapp.com/api/v1
```

### List events

Return all events

```
GET /event
```

### List events with filter

Return all events in accord with {search}

```
GET /event/{search}
```

### List teams

Return all teams

```
GET /team
```

### List teams with filter

Return all teams in accord with {search}

```
GET /team/{search}
```

### Creates a new event

Save a event

- [x] date
- [x] establishment
- [x] houseTeam
- [x] visitTeam

```
POST /event
```
