enum class Nivel {BASICO, INTERMEDIARIO, AVANCADO}

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
   
   val inscritos = mutableListOf<Usuario>()
   
   fun matricular(usuario: Usuario) {
       if (!inscritos.contains(usuario)){
           inscritos.add(usuario)
           println("${usuario.nome} foi matriculado(a) nessa formação $nome!")           
       }
       else {
           println("${usuario.nome} já está matriculado(a) nessa formação") 
       }
   }
   fun exibirDetalhes() {
       println("Formação: $nome")
       println("Conteúdos:")
       conteudos.forEach {conteudo ->
           println("-${conteudo.nome}(${conteudo.duracao}minutos, Nível: ${conteudo.nivel})")        
   }
   
   println("Total de inscritos: ${inscritos.size}")
   inscritos.forEach{println("-${it.nome}") }
   }
}

fun main() {
    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin", 90, Nivel.BASICO)
    val kotlinIntermediario = ConteudoEducacional("Programação Funcional com Kotlin",120, Nivel.INTERMEDIARIO)
    val kotlinAvancado = ConteudoEducacional("Corrotinas em Kotlin",180, Nivel.AVANCADO)
    
    val formacaoKotlin = Formacao("Formação Kotlin Developer", listOf(kotlinBasico, kotlinIntermediario, kotlinAvancado))
    
    
    val usuario1 = Usuario("Thami")
    val usuario2 = Usuario("Guilherme")
    
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    
    formacaoKotlin.exibirDetalhes()
    
    formacaoKotlin.matricular(usuario1)
    
}
   