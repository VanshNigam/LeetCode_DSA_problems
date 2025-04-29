class Solution:

    def combinationSum(self, arr: List[int], target: int) -> List[List[int]]:
        ans = []

        def help(arr, target, curr, i, lst):
            if i >= len(arr) or curr > target:
                return
            if curr == target:
                ans.append(lst[:])
                return

            lst.append(arr[i])
            help(arr, target, curr + arr[i], i, lst)

            lst.pop()
            help(arr, target, curr, i + 1, lst)
        help(arr, target, 0, 0, [])
        return ans
