from pymongo import MongoClient
client = MongoClient('mongodb+srv://test:sparta@cluster0.fmccarq.mongodb.net/?retryWrites=true&w=majority')
db = client.dbsparta


movie = db.movies.find_one({'title':'가버나움'})
star = movie['star']

all_movies = list(db.movies.find({'star':star},{'_id':False}))



db.movies.update_one({'title':'가버나움'},{'$set':{'star':'0'}})

