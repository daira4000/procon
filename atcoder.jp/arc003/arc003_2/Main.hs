module Main where

{-
  B - さかさま辞書
-}

sort :: [String] -> [String]
sort (x:xs) = sort [ls|ls<-filter (< x) xs]
              ++ [x]
              ++ sort [rs|rs<-filter (> x) xs]
sort [] = []

solver :: [String] -> [String]
solver = (map reverse) . sort . (map reverse)

main = do
  n <- getLine
  rs <- getContents
  putStr $ unlines $ solver (lines rs)

