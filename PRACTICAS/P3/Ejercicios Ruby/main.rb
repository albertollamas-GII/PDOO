require_relative 'Controlador_laberinto/controlador.rb'
require_relative 'vista2_laberinto.rb'
require_relative 'modelo_laberinto/laberinto.rb'

include Modelo_laberinto
include Controlador_laberinto

modelo = Laberinto.new()
controlador = Controlador.new(modelo)
vista = Vista2_laberinto.new(controlador, modelo)
vista.menu_usuario()
