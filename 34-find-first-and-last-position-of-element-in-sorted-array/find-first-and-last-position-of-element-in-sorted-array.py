import bisect


class Solution:
    def searchRange(self, arr: List[int], x: int) -> List[int]:
        n = len(arr)
        if n == 0:
            return [-1, -1]
        index = bisect.bisect_left(arr, x, 0, n)
        index_right = bisect.bisect_right(arr, x, 0, n) - 1

        if index < n and arr[index] != x:
            index = -1
        if index_right == n:
            index_right = -1
        if index == n:
            index = -1

        if index_right < n and arr[index_right] != x:
            index_right = -1
        return [index, index_right]
