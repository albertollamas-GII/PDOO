#encoding:utf-8
require_relative '../modelo_laberinto/elemento_separador.rb'
require_relative 'estado_juego.rb'
require_relative '../modelo_laberinto/laberinto.rb'
require_relative '../modelo_laberinto/habitacion.rb'
require_relative '../modelo_laberinto/direccion'


module Modelo_laberinto
  class Controlador

    def initialize (modelo)
      @modelo = modelo
      @vidas = 0
      @habitacion_usuario = nil
      @estado = Estado_juego::EN_ENTRADA_LABERINTO

    end

    attr_reader :vidas
    attr_reader :estado
    attr_reader :habitacion_usuario

    def entrar(vidas)
      @vidas = vidas
      @estado = Estado_juego::DENTRO_VIVO

      @habitacion_usuario = @modelo.puerta_entrada.habitacion_al_otro_lado(@habitacion_usuario)

      pared=Elemento_separador.nueva_pared(nil, @habitacion_usuario)
      @habitacion_usuario.set_lado(Direccion::SUR, pared)
    end

    def intentar_avanzar()
      num = Random.rand(3)

      case num
      when num == 0
        if (@habitacion_usuario.pasar(Direccion::NORTE))
          @habitacion_usuario = @habitacion_usuario.get_lado(Direccion::NORTE).habitacion_al_otro_lado(@habitacion_usuario)
        else
          @vidas = @vidas - 1
        end
        puts Direccion::NORTE
      when num == 1
          if (@habitacion_usuario.pasar(Direccion::SUR))
            @habitacion_usuario = @habitacion_usuario.get_lado(Direccion::SUR).habitacion_al_otro_lado(@habitacion_usuario)
          else
            @vidas = @vidas - 1
          end
          puts Direccion::SUR
      when num == 2
            if (@habitacion_usuario.pasar(Direccion::ESTE))
              @habitacion_usuario = @habitacion_usuario.get_lado(Direccion::ESTE).habitacion_al_otro_lado(@habitacion_usuario)
            else
              @vidas = @vidas - 1
            end
            puts Direccion::ESTE
      when num == 3
              if (@habitacion_usuario.pasar(Direccion::OESTE))
                @habitacion_usuario = @habitacion_usuario.get_lado(Direccion::OESTE).habitacion_al_otro_lado(@habitacion_usuario)
              else
                @vidas = @vidas - 1
              end
              puts Direccion::OESTE
      end

      if (@vidas == 0)
        @estado = Estado_juego::DENTRO_MUERTO
      end
    end
  end
end