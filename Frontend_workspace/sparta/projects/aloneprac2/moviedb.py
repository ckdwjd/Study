from pymongo import MongoClient
client = MongoClient('mongodb+srv://test:sparta@cluster0.fmccarq.mongodb.net/?retryWrites=true&w=majority')
db = client.dbsparta

db.movies2.update_one({'title': '가버나움'}, {'$set': {'star': '0'}})
