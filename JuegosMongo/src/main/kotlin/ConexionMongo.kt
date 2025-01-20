import com.mongodb.client.FindIterable
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Updates
import io.github.cdimascio.dotenv.dotenv
import org.bson.Document

    class ConexionMongo {

        private val mongoClient: MongoClient by lazy {
            val dotenv = dotenv()
            val connectString = dotenv["URL_MONGODB"]

            MongoClients.create(connectString)
        }

        fun getDatabase(bd: String) : MongoDatabase {
            return mongoClient.getDatabase(bd)
        }

        fun close() {
            mongoClient.close()
        }

    }
