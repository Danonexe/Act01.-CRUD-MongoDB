package repository

import ConexionMongo
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.model.Filters
import io.github.cdimascio.dotenv.dotenv
import org.bson.conversions.Bson

class readJuegos {
    // Objeto para usar la conexión
    private val Conexion = ConexionMongo() // Inicializa la conexión
    private val database = Conexion.getDatabase("adaprueba")

    fun ListarTodosLosJuegos(){
        try {
            // Obtener la colección
            val collection = database.getCollection("JuegosMongo")

            // Lista
            val dosConsulta = collection.find()

            dosConsulta.forEach{
                    doc->
                println(doc.toString())
            }

        } catch (e: Exception) {
            println("Error al conectar a MongoDB: ${e.message}")
        }
    }

    fun BuscarPorGenero(genero:String){
        try {
            // Obtener la colección
            val collection = database.getCollection("JuegosMongo")

            // Filtro
            println("Juegos con el género: $genero")
            val filtroBuscarPorGenero: Bson = Filters.eq("genero", genero)
            val busqueda = collection.find(filtroBuscarPorGenero)

            busqueda.forEach{ println(it) }

        } catch (e: Exception) {
            println("Error al conectar a MongoDB: ${e.message}")
        }
    }
}