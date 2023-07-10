def solution(nums):
    return len(nums) / 2 if len(nums) / 2 < len(set(nums)) else len(set(nums))