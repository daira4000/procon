module Main where

{-
  B - 割り切れる日付
-}

isLeap :: Int -> Bool
isLeap y | y `mod` 400 == 0 = True
         | y `mod` 100 == 0 = False
         | y `mod` 4 == 0 = True
         | otherwise = False

dayList :: Int -> Int -> Int -> [(Int, Int, Int)]
dayList year month day = [(y,m,d) | y <- [year..],
                                    m <- [1..12],
                                    d <- head $ reverse $ take m $ days y,
                                    y > year || y == year && (m > month || m == month && d >= day)]

days y = [[1..31],
          [1..(if isLeap y then 29 else 28)],
          [1..31],
          [1..30],
          [1..31],
          [1..30],
          [1..31],
          [1..31],
          [1..30],
          [1..31],
          [1..30],
          [1..31]]

solver :: String -> String
solver date = dateToString $ head $ [(y, m, d)| (y,m,d)<-list, y `mod` (m * d) == 0]
  where
    breakDate = break (== '/') . dropWhile (== '/')
    (year, temp) = breakDate date
    (month, temp2) = breakDate temp
    day = tail temp2
    list = dayList (read year) (read month) (read day)
    
    dateToString :: (Int, Int, Int) -> String
    dateToString (y, m, d) = (format y 4) ++ "/" ++
                             (format m 2) ++ "/" ++
                             (format d 2)
      where
        format :: Int -> Int -> String
        format no n = reverse $ take n $ reverse $ (take n $ repeat '0') ++ (show no)

main = do
  s <- getLine
  putStrLn $ solver s
