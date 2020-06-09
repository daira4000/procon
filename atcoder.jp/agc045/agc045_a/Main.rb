def solv
  n = gets.to_i
  a = gets.split.map(&:to_i).reverse
  s = gets.chomp.split("").map(&:to_i).reverse

  x = [0]
  n.times do |i|
    p = s[i]
    b = a[i]
    x.each do |v|
      b = [b, b^v].min
    end
    if p == 0
      x << b
    else
      return 1 if b != 0
    end
  end
  return 0
end

t = gets.to_i
t.times do |i|
  puts solv
end
