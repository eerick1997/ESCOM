#include <bits/stdc++.h>

using namespace std;

int TBL[1000002];
void buildKMstrTBL(string &str)
{
    int i = 0, j = -1, m = str.size();
    TBL[0] = -1;
    while (i < m)
    {
        while (j >= 0 && str[i] != str[j])
            j = TBL[j];
        TBL[++i] = ++j;
    }
}

int main()
{
    string s;
    cin >> s;
    buildKMstrTBL(s);
    int ans = TBL[s.size()];
    bool b = false;
    while (ans > 0)
    {
        for (int i = s.size() - 1; i > ans && !b; i--)
            b = TBL[i] >= ans;
        if (b)
            break;
        ans = TBL[ans];
    }
    if (b)
        cout << s.substr(0, ans);
    else
        cout << "Just a legend";
    cout << endl;
}