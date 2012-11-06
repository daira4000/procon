module Main where

{-
  A - GPA計算
-}

convertGPA :: String -> [Int]
convertGPA (x:xs) = (_convert x) : (convertGPA xs)
                    where
		      _convert x | x == 'A' = 4
		                 | x == 'B' = 3
				 | x == 'C' = 2
				 | x == 'D' = 1
				 | x == 'F' = 0
convertGPA otherwise = []

solver :: String -> Int
solver = sum . convertGPA

main = do
  n <- getLine
  rs <- getLine
  print (fromIntegral (solver rs) / read n)
