module Main where


{-
  C - コマンド入力
-}

sets = [[a,b]|a<-"ABXY", b<-"ABXY"]
pair = [(l,r)|l<-sets, r<-sets, l /= r]

solver cmd = minimum [count [l,r] cmd|(l,r)<-pair]
  where
    count lr (x1:x2:xs) | any (== [x1,x2]) lr = 1 + count lr xs
                        | otherwise           = 1 + count lr (x2:xs)
    count lr xs = length xs

main = do
  n <- getLine
  s <- getLine
  putStrLn $ show $ solver $ take (read n) s
