class A
  protected
  def protegidoA
  end
end

class B < A
  protected
  def protegidoB
  end
end

class C < B
  protected
  def protegidoC
  end

  public
  def test
    A.new.protegidoA
    B.new.protegidoA
    B.new.protegidoB
    C.new.protegidoA
    C.new.protegidoB
    C.new.protegidoC
    D.new.protegidoA
    #D.new.protegidoD
  end
end

class D < C
  protected
  def protegidoD
  end
end

C.new.test
#C.new.protegidoC
