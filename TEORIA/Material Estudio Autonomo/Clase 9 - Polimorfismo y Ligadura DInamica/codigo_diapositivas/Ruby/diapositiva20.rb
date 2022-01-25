class Padre
  def interno
    puts "  Interno padre "
  end

  def metodo
    puts "Voy a actuar: "
    interno
  end
end

class Hija < Padre
  def interno
    puts "  Interno hijo"
  end
end

Padre.new.metodo # Voy a actuar: Interno padre
Hija.new.metodo # Voy a actuar: Interno hijo
