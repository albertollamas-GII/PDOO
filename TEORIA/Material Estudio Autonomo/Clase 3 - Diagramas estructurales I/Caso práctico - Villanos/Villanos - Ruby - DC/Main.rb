#Esta clase no está en el diagrama, se ha añadido para que la puedas
# ejecutar y veas las implicaciones de usar clases que pertenecen a módulos
# diferentes

require_relative "./Mayordomo.rb"
require_relative "Villano.rb"

minion = Esbirros::Mayordomo.new("Minion")
gru = Villanos::Villano.new("Gru", "Casa", 10000, minion)
puts gru.to_s
