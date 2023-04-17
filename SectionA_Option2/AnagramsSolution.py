class Solution:

    # takes a list of strings and groups the anagrams into nested lists.
    def groupAnagrams(self, strs):
        result = {}

        # loops through the string list to find the anagrams and appends them to the results list as nested.
        for i in strs:
            x = "".join(sorted(i))
            if x in result:
                result[x].append(i)
            else:
                result[x] = [i]
        # returns anagrams.
        return list(result.values())


# creates a new object of the Solution class.
ob1 = Solution()

print(ob1.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
