class A
  def initialize(a)
    puts "Creando A"
    @a = a
	puts @a
  end
end
8
class B < A
end

A.new(77)
#B.new
B.new(88)
