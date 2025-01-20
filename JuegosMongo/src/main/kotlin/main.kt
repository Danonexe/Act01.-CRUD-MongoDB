import model.Juego
import repository.createJuegos
import repository.deleteJuegos
import repository.readJuegos
import repository.updateJuegos

fun main() {
    // Objeto para usar las funciones
    val read = readJuegos()
    val create = createJuegos()
    val update = updateJuegos()
    val delete = deleteJuegos()

    var opcion: String
    do {
        println("Menú CRUD juegos, escribe que quieres hacer")
        println("0. Salir")
        println("1. Ver todos los juegos")
        println("2. Buscar por género")
        println("3. Insertar un juego")
        println("4. Editar un juego")
        println("5. Borrar juegos por género")
        opcion= readLine().toString()
        if(opcion=="1"){
            read.ListarTodosLosJuegos()
        }
        if(opcion=="2"){
            println("¿Que género quieres buscar?")
            val genero= readLine().toString()
            read.BuscarPorGenero(genero)
        }
        if(opcion=="3"){
            println("Escribe el nombre del juego:")
            val titulo = readLine().toString()
            println("Escribe el género del juego:")
            val generoJuego = readLine().toString()
            println("Escribe el precio del juego:")
            val precio = readLine()?.toDoubleOrNull()
            println("Escribe la fecha de lanzamiento:")
            val fechaDeLanzamiento = readLine().toString()
            val juego = Juego(titulo, generoJuego, precio, fechaDeLanzamiento)
            create.CreateJuego(juego)
        }
        if(opcion=="4"){
            println("Escribe el título del juego que quieres actualizar:")
            val buscarTitulo = readLine().toString()
            println("Escribe el nuevo nombre del juego:")
            val titulo = readLine().toString()
            println("Escribe el nuevo género del juego:")
            val generoJuego = readLine().toString()
            println("Escribe el nuevo precio del juego:")
            val precio = readLine()?.toDoubleOrNull()
            println("Escribe la nueva fecha de lanzamiento:")
            val fechaDeLanzamiento = readLine().toString()
            val juego = Juego(titulo, generoJuego, precio, fechaDeLanzamiento)
            update.updateJuego(juego,buscarTitulo)
        }
        if (opcion=="5"){
            println("Escribe el género de los juegos que quieres borrar")
            val genero= readLine().toString()
            delete.borrarPorGenero(genero)
        }
        println("")
    }while (opcion != "0")

}