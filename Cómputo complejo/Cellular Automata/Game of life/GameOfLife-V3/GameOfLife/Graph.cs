using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameOfLife
{
    class Graph
    {
        private Dictionary<ulong, List<ulong>> nodes;
        
        public Graph(Dictionary<ulong, List<ulong>> init_nodes) {
            nodes = new Dictionary<ulong, List<ulong>>(init_nodes);
        }

        public void addNodes(ulong key, List<ulong> value) {
            nodes.Add(key, value);
        }

        public ulong getTotalVerticesPerNode() {
            ulong vertices = 0;
            foreach (KeyValuePair<ulong, List<ulong>> item in nodes) {
                vertices += (ulong)item.Value.Count;
            }
            return vertices;
        }

        public ulong getKeyInt() {
            return getTotalVerticesPerNode();
        }
        public string getKey() {

            Dictionary<ulong, ulong> pre_key = new Dictionary<ulong, ulong>();
            foreach (KeyValuePair<ulong, List<ulong>> item in nodes) {

                if (!pre_key.ContainsKey(item.Key))
                    pre_key.Add(item.Key, 1);

                for (int i = 0; i < item.Value.Count; i++) {
                    if (pre_key.ContainsKey(item.Value[i]))
                    {
                        pre_key[item.Value[i]]++;
                    }
                    else {
                        pre_key.Add(item.Value[i], 1);
                    }
                }
            }

            string key = "";
            foreach (KeyValuePair<ulong, ulong> item in pre_key) {
                key += item.Value + ((pre_key.Last().Key == item.Key) ? "" : ",");
            }
            return key;
        }

        private void printList(List<ulong> list) {
            Console.WriteLine();
            for (int i = 0; i < list.Count; i++) {
                Console.Write(list[i] + " ");
            }
            Console.WriteLine();
        }
        public Dictionary<ulong, List<ulong>> getAllNodes() {
            return nodes;
        }

        public void printStates() {
            Console.WriteLine("Printing states");
            foreach (KeyValuePair<ulong, List<ulong>> item in nodes) {
                Console.Write(item.Key + " -> ");
                for (int i = 0; i < item.Value.Count; i++) {
                    Console.Write(item.Value[i] + " ");
                }
                Console.WriteLine();
            }
        }

        public void toMathematica() {
            foreach (KeyValuePair<ulong, List<ulong>> item in nodes)
            {
                for (int i = 0; i < item.Value.Count; i++)
                {
                    Console.Write(item.Value[i] + " -> " + item.Key + ",");
                }
            }
        }


    }
}
