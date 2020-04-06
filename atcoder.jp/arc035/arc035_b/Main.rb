MOD = (1e9+7).to_i

N = gets.to_i
T = []
(1..N).each{|n| T << gets.to_i}
T.sort!
bucket = {}
min = 0
tmp = 0
T.each do |t|
    min += tmp + t
    tmp += t
    bucket[t] = bucket[t].to_i + 1
end
cmb = 1
bucket.keys.sort.each do |k|
    v = bucket[k]
    p = 1
    (2..v).each {|n| p *= n}
    cmb = cmb * p
    cmb %= MOD
end
puts min
puts cmb