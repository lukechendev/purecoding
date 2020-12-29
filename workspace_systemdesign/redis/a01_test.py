import redis

r = redis.Redis(
    host='localhost',
    port=6379)

r.set('name', 'lchen')
name = r.get('name')
print(name)
