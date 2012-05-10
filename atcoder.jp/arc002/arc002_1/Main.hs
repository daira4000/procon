module Main where

{-
  A - うるう年
-}
isLeap :: Int -> Bool
isLeap y | y `mod` 400 == 0 = True
         | y `mod` 100 == 0 = False
         | y `mod` 4 == 0 = True
         | otherwise = False

solver :: String -> String
solver year | isLeap $ read year = "YES"
            | otherwise = "NO"

main = do
  s <- getLine
  putStrLn $ solver s
