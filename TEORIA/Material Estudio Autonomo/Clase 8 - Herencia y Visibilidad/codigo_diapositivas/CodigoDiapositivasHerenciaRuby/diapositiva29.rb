class G
  def initialize
    puts "Creando G"
    @g = 66
  end
end

class H < G
  def initialize
    puts "Creando H"
    @h = 88
  end
end

G.new
h = H.new
puts h.inspect
