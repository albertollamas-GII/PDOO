# encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# si se depura hay que desactivar console prompt
require_relative 'Controlador_laberinto/estado_juego.rb'
class Vista_laberinto
  def initialize(controlador)
    @controlador = controlador
  end

  def menu_usuario()
    estado = @controlador.estado
    values=[*1..10].map!(&:to_s)

    case estado
    when Estado_juego::EN_ENTRADA_LABERINTO
      puts "Intoduzca el número de vidas (entre 1 y 10) antes de entrar en el laberinto"
      st=gets.chomp

      while (!values.include? st)
        puts "Intoduzca el número de vidas (entre 1 y 10) antes de entrar en el laberinto"
        st=gets.chomp
      end
      @controlador.entrar(st.to_i)

    when Estado_Juego::DENTRO_VIVO
      informe_dentro(@controlador.habitacion_usuario, @controlador.vidas)

      puts "Pulse una tecla"
      st = gets.chomp
      puts @controlador.intentar_avanzar()

    when Estado_juego::EN_SALIDA_LABERINTO
      informe_final(@controlador.habitacion_usuario, @controlador.vidas)

    when Estado_juego::DENTRO_MUERTO
      informe_final(@controlador.habitacion_usuario,0)
    end
    menu_usuario
  end

  def informe_dentro(habitacion, vidas)
    puts "Esta en la habitacion " + habitacion + " y le quedan " + vidas + " vidas."
  end

  def informe_final(habitacion, vidas)
    if (vidas > 0)
      puts "Esta en la habitacion " + habitacion + " y le quedan " + vidas + " vidas."
    else
      puts "Ha muerto en la habitacion " + habitacion
    end
  end
end
